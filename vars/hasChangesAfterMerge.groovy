def boolean hasChangesAfterMerge(String module) {
    return bat(
            returnStatus: true,
            script: "git diff --name-only --merge-base --exit-code HEAD~1 HEAD ${module}",
            label: "Check git diff on branch changes for ${module}"
    ) == 1 ||
            bat(
                    returnStatus: true,
                    script: "git diff --name-only --merge-base --exit-code HEAD~1 HEAD pom.xml",
                    label: "Check git diff on branch changes for pom.xml"
            ) == 1
}