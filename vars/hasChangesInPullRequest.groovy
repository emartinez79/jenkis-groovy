def boolean hasChangesInPullRequest(String module) {
    return bat(
            returnStatus: true,
            script: "git diff --name-only --merge-base --exit-code origin/develop ${module}",
            label: "Check git diff on PR changes for ${module}"
    ) == 1
}