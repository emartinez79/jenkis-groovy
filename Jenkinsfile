pipeline
{
    agent any
    stages
    {
        stage('build')
        {
            steps
            {
                script
                {
                    //first.groovy path might change as per your need
                    def var1 = load "first.groovy"
                    var1.build("php build")
                }
                sh '''
                echo "build"
                '''
            }
        }
        
        stage('deploy')
        {
            steps
            {
                script
                {
                    def var2 = load "first.groovy"
                    var2.build("php deploy")
                }
                    sh '''
                    echo "deploy"
                    '''
            }
        }
        
        
    }
}
