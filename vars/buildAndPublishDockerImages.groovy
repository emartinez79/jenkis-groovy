def void buildAndPublishDockerImages(String module) {
    withCredentials([usernamePassword(credentialsId: 'ac82330e-941f-4925-a3c4-5459b55ed1db', passwordVariable: '$AUTH_PSW', usernameVariable: '$AUTH_USR')]) {
        def tag = getTagByBranch()
        if (module == "suitedx-core-front-end") {
            bat script: "docker-compose -f docker-compose-fe.yml build ${module}", label: "Docker build fe ${module}"
        } else if (module == "suitedx-core-commons") {
            bat script: "docker build -t ${module}:latest -f suitedx-core-commons/Dockerfile .", label: "Docker build ${module} image"
        } else {
            bat script: "docker-compose -f docker-compose-be.yml build ${module}", label: "Docker build be ${module}"
        }

        bat script: "docker image tag ${module}:latest mdxregistry.azurecr.io/dx-software-suite_${module}:${tag}", label: "Docker tag image ${module}"
        bat script: 'docker login mdxregistry.azurecr.io -u=%AUTH_USR% -p=%AUTH_PSW%"', label: 'Docker login remote hub'
        bat script: "docker push mdxregistry.azurecr.io/dx-software-suite_${module}:${tag}", label: "Docker push image ${module}"
    }
}