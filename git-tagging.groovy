pipeline {
    agent any
    stages {
        stage('Git Checkout') {
            steps {
                git 'https://github.com/nxdevops/hiNotebook'
            }
        }

        stage('Git Bump ') {
            steps {
                sh 'sudo chmod -R 0777 /usr/local/bin/gitversion'
                sh 'gitversion bump auto'
          
            }
        }
        
        stage('Git tagging & Push Updated Version') {
            steps {   
                sh 'git push https://${gitToken}@github.com/nxdevops/hiNotebook.git --tags'
               
            }
        }
    }
}