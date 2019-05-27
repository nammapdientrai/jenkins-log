node {
    build "job-01"
    build "job-02"
    build "job-03"

    sh "curl -X POST 'http://192.168.56.106:8080/jenkins/job/jenkins_log/job/job-log-master/8/consoleText' >> '/home/namth22/show-log/'"
}

//curl -X POST "http://tunv3:<API Token>@10.88.96.170:8080/job/$JobName/$BuildNumber/consoleText" >> "/var/lib/jenkins/logs/$JobName/$BuildNumber.log"
//curl -X POST "http://tunv3:<API Token>@10.88.96.170:8080/job/$JobName/$BuildNumber/api/json" >> "/var/lib/jenkins/logs/$JobName/$BuildNumber.json"

