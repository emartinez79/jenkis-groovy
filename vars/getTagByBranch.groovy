def String getTagByBranch() {
    switch (BRANCH_NAME) {
        case "develop":
            return "latest"
        case "integration":
            return "${ORIGINAL_SUITE_VERSION}-beta"
        case "release":
            return "${ORIGINAL_SUITE_VERSION}"
    }
}