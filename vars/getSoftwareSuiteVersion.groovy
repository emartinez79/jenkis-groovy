def String getSoftwareSuiteVersion() {
    def fileName = "suitedx-core-system-info\\suitedx-core-system-info-service\\src\\main\\resources\\application.yml"
    def fileContent = readFile file: fileName
    def ymlData = readYaml text: fileContent
    def originalVersion = ymlData.systeminfo.build.version
    return "${originalVersion}"
}

return this