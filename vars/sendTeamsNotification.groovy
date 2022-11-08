def sendTeamsNotification() {
    def changelog = powershell returnStdout: true, script: "git log -1 --pretty=%B"
    def userName = powershell returnStdout: true, script: "git log -1 --pretty=format:%an%x20%x2D%x20%ae"
    def body =
            "{" +
                    "\"\"buildId\"\": \"\"${BUILD_DISPLAY_NAME}\"\"," +
                    "\"\"branchName\"\": \"\"${BRANCH_NAME}\"\"," +
                    "\"\"createdBy\"\": \"\"${userName.trim()}\"\"," +
                    "\"\"agent\"\": \"\"${NODE_NAME}\"\"," +
                    "\"\"changelog\"\": \"\"${changelog.trim()}\"\"," +
                    "\"\"url\"\": \"\"${BUILD_URL}\"\"" +
                    "}"
    def url = "https://prod-26.westeurope.logic.azure.com:443/workflows/b8b186f749624d7286ac16b2458b8c5b/triggers/manual/paths/invoke?api-version=2016-06-01&sp=%2Ftriggers%2Fmanual%2Frun&sv=1.0&sig=a2A9Ca45NL-ishEajxreRUN7vllwvxp6dkHC-QCEOUU"
    powershell script: "Invoke-RestMethod -Method 'Post' -Uri \"${url}\" -Body \"${body}\" -ContentType \"application/json\""
}