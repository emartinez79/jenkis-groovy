def modifyPomWithSonarInclusions(String sonarInclusions) {
    def fileContent = readFile file: 'pom.xml'
    bat script: "echo \"sonar-inclusions: ${sonarInclusions}\""
    writeFile file: 'pom.xml', text: fileContent.replace("SONAR_INCLUSIONS", "${sonarInclusions}")
}