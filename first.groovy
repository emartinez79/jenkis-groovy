def build(String arg1) {
        sh """
        echo "from build function : ${arg1}"
        """
}

def deploy(String arg2) {
        sh """
        echo "from deploy function : ${arg2}"
        """
}

return this
