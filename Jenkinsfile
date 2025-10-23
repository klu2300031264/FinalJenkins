pipeline {
    agent any

    stages {

        // ===== FRONTEND BUILD =====
        stage('Build Frontend') {
            steps {
                dir('frontend-reactapp') {
                    bat 'npm install'
                    bat 'npm run build'
                }
            }
        }

        // ===== FRONTEND DEPLOY =====
        stage('Deploy Frontend to Tomcat') {
            steps {
                bat """
                if exist "C:\\Program Files\\Apache Software Foundation\\Tomcat 10.1\\webapps\\jenkinsfron1" (
                    rmdir /S /Q "C:\\Program Files\\Apache Software Foundation\\Tomcat 10.1\\webapps\\jenkinsfron1"
                )
                mkdir "C:\\Program Files\\Apache Software Foundation\\Tomcat 10.1\\webapps\\jenkinsfron1"
                xcopy /E /I /Y frontend-reactapp\\dist\\* "C:\\Program Files\\Apache Software Foundation\\Tomcat 10.1\\webapps\\jenkinsfron1"
                """
            }
        }

        // ===== BACKEND BUILD =====
        stage('Build Backend') {
            steps {
                dir('backend-springbootapp') {
                    bat 'mvn clean package'
                }
            }
        }

        // ===== BACKEND DEPLOY =====
        stage('Deploy Backend to Tomcat') {
        steps {
        bat '''
            if exist "C:\\Program Files\\Apache Software Foundation\\Tomcat 10.1\\webapps\\jenkinsback1.war" (del /Q "C:\\Program Files\\Apache Software Foundation\\Tomcat 10.1\\webapps\\jenkinsback1.war" )
            if exist "C:\\Program Files\\Apache Software Foundation\\Tomcat 10.1\\webapps\\jenkinsback1" (rmdir /S /Q "C:\\Program Files\\Apache Software Foundation\\Tomcat 10.1\\webapps\\jenkinsback1" )
            copy "backend-springbootapp\\target\\*.war" "C:\\Program Files\\Apache Software Foundation\\Tomcat 10.1\\webapps\\jenkinsback1.war"
        '''
      }
     }


    }

    post {
        success {
            echo 'Deployment Successful!'
        }
        failure {
            echo 'Pipeline Failed.'
        }
    }
}