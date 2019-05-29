curl -X POST "http://tunv3:<API Token>@10.88.96.170:8080/job/$JobName/$BuildNumber/consoleText" >> "/var/lib/jenkins/logs/$JobName/$BuildNumber.log"
curl -X POST "http://tunv3:<API Token>@10.88.96.170:8080/job/$JobName/$BuildNumber/api/json" >> "/var/lib/jenkins/logs/$JobName/$BuildNumber.json"



curl -X POST -u "namth22:Thn#025381961" "http://10.88.96.206:80/jenkins/job/DevOps-Training/job/namth22/job/namth22-docker-file-compose/74/consoleText" > "/home/training/support-jira/100.log"

