node {
    build "job-01"
    build "job-02"
    build "job-03"

    def logContent = Jenkins.getInstance()
                .getItemByFullName(env.JOB_NAME)
                .getBuildByNumber(
                    Integer.parseInt(env.BUILD_NUMBER))
                .logFile.text

    // copy the log in the job's own workspace
    writeFile file: "buildlog.txt", text: logContent
}