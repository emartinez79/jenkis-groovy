def String retrieveEnvironmentAgentNumber() {
    switch (BRANCH_NAME) {
        case "develop":
            return "002"
        case "integration":
            return "003"
        case "release":
            return "004"
        default: // Pull Requests
            return "001"
    }
}