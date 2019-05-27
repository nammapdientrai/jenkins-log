node {
    //def JobName = "${env.JOB_NAME}"
    def JobName = "jenkins_log/job/jenkins-log-master"
    def BuildNumber = "${env.BUILD_NUMBER}"

    set +x
    sh "echo '${JobName} ${BuildNumber}' >> /home/namth22/show-log/info.log"
    set -x
    
    build "job-01"
}

//curl -X POST "http://tunv3:<API Token>@10.88.96.170:8080/job/$JobName/$BuildNumber/consoleText" >> "/var/lib/jenkins/logs/$JobName/$BuildNumber.log"
//curl -X POST "http://tunv3:<API Token>@10.88.96.170:8080/job/$JobName/$BuildNumber/api/json" >> "/var/lib/jenkins/logs/$JobName/$BuildNumber.json"

