def String setSoftwareSuiteVersion() {
    def fileName = "suitedx-core-system-info\\suitedx-core-system-info-service\\src\\main\\resources\\application.yml"
    def fileContent = readFile file: fileName
    def originalVersion = getSoftwareSuiteVersion()
    def newVersion = "${originalVersion}" + "-${BRANCH_NAME}${BUILD_DISPLAY_NAME}"
    bat script: "del ${fileName}"
    writeFile file: fileName, text: fileContent.replace("${originalVersion}", "${newVersion}")
    return "${newVersion}"
}