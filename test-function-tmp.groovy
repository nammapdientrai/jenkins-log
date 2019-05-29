//Return result final, include: full log child
def List<String> doResultFinal(List<String> resultFinal, List<String> summary, List<String> point){
    def logChild = (List<String>) []
    def tmp = (List<String>) []

    for(int i = 0; i < summary.size(); i++){
        if( !point.contains(summary[i]) ) {
            /*while(checkStop(getLogChild(summary[i].trim()))){
                echo "================ 22222222"
                logChild = getLogChild( summary[i].trim() )
            }*/
        } else{
            if( !resultFinal.contains( summary[i].trim() ) ) {
                resultFinal.add( summary[i] )
            }
        }
    }

    return resultFinal
}


//Get log child in pipeline running
def List<String> getLogChild(String line) {
    def l = (List<String>) line.split(" ")

    def size = l.size() - 1

    def JobName = l[size-1]
    def BuildNumber = l[size].substring(1)

    return getLog(JobName, BuildNumber)
}


def List<String> checkJobExist(List<String> point, List<String> l){
    for(int i = 0; i < l.size(); i++){
        def lines = (List<String>) l[i].split(" ")
    
        def s = lines[0].trim() + " " + lines[1].trim()

        if(s.trim() == "Starting building:"){
            if( !point.contains( l[i].trim() ) ){
                point.add(l[i])
            }
        }
    }
    return point
}

node ("namth22_10.88.96.126"){
    def JobName = "jenkins-log"

    def summary = (List<String>) []

    def status = true

    while(status)
        def tmp = getLog(JobName, BuildNumber)

        summary = mergeLog(summary, tmp)

        sleep(3)

        if(summary.size() > 0 && checkStop( summary[summary.size() -1].trim() ) ) {
            status = false
        }
    }
}


def List<String> getLog(String JobName, String BuildNumber) {
    def log = sh(returnStdout: true, script: "curl -X GET -u 'namth22:Thn#025381961' 'http://10.88.96.206:80/jenkins/job/${JobName}/${BuildNumber}/consoleText'")

    def list = (List<String>) log.split("\n")

    return list
}

def List<String> mergeLog(List<String> summary, List<String> tmp) {
    def sizeSummary = summary.size()
    def sizeTmp = tmp.size()

    def status = true
    def count = 0

    if(sizeSummary <= 0){
        if(tmp[0] != "<html>" && tmp[sizeTmp - 1] != "</html>"){
            for(int i = 0; i < tmp.size(); i++){
                pushMessageLog(i, tmp[i])
            }

            return tmp
        } 
    } else{
        for(int i = sizeSummary; i < sizeTmp; i++){
            summary[i] = tmp[i]

            // Get log child --------------------------------------
            def line = (List<String>) summary[i].split(" ")
    
            def s = line[0].trim() + " " + line[1].trim()

            if(s.trim() == "Starting building:"){
                def size = line.size() - 1
                def JobName = line[size-1].trim()
                def BuildNumber = line[size].substring(1).trim()

                def logChild = (List<String>) []

                while(status) {
                    def logChildTmp = getLog(JobName, BuildNumber)

                    logChild = mergeLog(logChild, logChildTmp)

                    sleep(3)

                    if(logChild.size() > 0 && checkStop( logChild[logChild.size() -1].trim() ) ) {
                        status = false
                    }
                }
            }
            // -----------------------------------------------------

            pushMessageLog(i, summary[i])
        }
    }

    return summary
}

def pushMessageLog(int stt, String message){
    // Push message to server---------
    echo "====================================="
        echo stt + " : " + message
    echo "====================================="
    // -------------------------------
}

/*
-------------------------------------------------------
*/
//Check when status to stop loop
def boolean checkStop(String status) {
    switch(status) {
        case "Finished: SUCCESS":
        case "Finished: FAILURE":
        case "Finished: ABORTED":
            return true
    }

    return false;
}
/*
-------------------------------------------------------
*/





