node {
    stage ("Run job") {
        build "job-01"
        build "job-02"
        build "job-03"
    }
    
    stage ("Create file log") {
        sh "curl -X POST 'http://192.168.56.106:8080/jenkins/job/$JobName/$BuildNumber/consoleText' >> '/home/namth22/show-log/$BuildNumber.log'"
    }
}

//curl -X POST "http://tunv3:<API Token>@10.88.96.170:8080/job/$JobName/$BuildNumber/consoleText" >> "/var/lib/jenkins/logs/$JobName/$BuildNumber.log"
//curl -X POST "http://tunv3:<API Token>@10.88.96.170:8080/job/$JobName/$BuildNumber/api/json" >> "/var/lib/jenkins/logs/$JobName/$BuildNumber.json"

