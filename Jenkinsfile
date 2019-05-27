node {
    //def JobName = "${env.JOB_NAME}"
    def JobName = "jenkins_log/job/jenkins-log-master"
    def BuildNumber = "${env.BUILD_NUMBER}"

    sh "'${JobName} ${BuildNumber}' >> /home/namth22/show-log/info.log"

    stage ("Run job") {
        build "job-01"
        //build "job-02"
    }
}

//curl -X POST "http://tunv3:<API Token>@10.88.96.170:8080/job/$JobName/$BuildNumber/consoleText" >> "/var/lib/jenkins/logs/$JobName/$BuildNumber.log"
//curl -X POST "http://tunv3:<API Token>@10.88.96.170:8080/job/$JobName/$BuildNumber/api/json" >> "/var/lib/jenkins/logs/$JobName/$BuildNumber.json"

