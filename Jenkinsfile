/*node ("namth22_10.88.96.126"){
    def JobName = "${env.JOB_NAME}"
    def BuildNumber = "${env.BUILD_NUMBER}"
    
    sh "rm -rf /home/training/show-log/*"
    sh "echo '${JobName} ${BuildNumber}' >> /home/training/show-log/info.log"

    build "jenkins-job1"
    build "jenkins-job2"

    sh "curl -X GET -u 'namth22:Thn#025381961' 'http://10.88.96.206:80/jenkins/job/DevOps-Training/job/namth22/job/namth22-docker-file-compose/74/consoleText' > '/home/training/show-log/74.log'"
}

def getLogChild(String line) {
    def l = (ArrayList<String>) line.split(" ")

    def size = l.size() - 1

    def JobName = l[size-1]
    def BuildNumber = l[size].substring(1)

    writeFile(JobName, BuildNumber)
}*/

node ("namth22_10.88.96.126"){
    def JobName = "DevOps-Training/job/SP_Jenkins_catch_logs/job/jenkins-log"
    def Path = "/home/training/show-log"

    for(int i = 0; i < 15; i++){
        writeFile(JobName, BuildNumber, Path)

        sleep(3)
    }

    echo "------------------------------------------------------------------"
    //echo "" + readFileInList("${Path}/${JobName}/${BuildNumber}" + ".txt")
    echo "------------------------------------------------------------------"
}

def writeFile(String JobName, String BuildNumber, String Path) {
    sh "mkdir -p -m 777 '/home/training/show-log/${JobName}'"

    sh "curl -X GET -u 'namth22:Thn#025381961' 'http://10.88.96.206:80/jenkins/job/${JobName}/${BuildNumber}/consoleText' > '${Path}/${JobName}/${BuildNumber}.txt'"
    //sh "curl -X GET -u 'namth22:Thn#025381961' 'http://10.88.96.206:80/jenkins/job/${JobName}/${BuildNumber}/consoleText'"
}

def List<String> readFileInList(String filePath) {
    def lines = readFile(filePath);
    def list = (List<String>) lines.split("\n")

    return list
}





