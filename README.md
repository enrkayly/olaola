# Fanla Application

## Deploying to Render

This guide will help you deploy the Fanla application to Render.

### Prerequisites

1. A Render account (https://render.com)
2. Your code pushed to a GitHub repository

### Deployment Steps

1. **Log in to Render**: Go to https://dashboard.render.com and log in to your account.

2. **Create a new Web Service**:
   - Click on "New +" and select "Web Service".
   - Connect your GitHub repository where you've pushed your code.
   - Select the repository containing your Fanla application.

3. **Configure the Web Service**:
   - Name: `fanla-app` (or any name you prefer)
   - Environment: `Docker`
   - Branch: `main` (or your default branch)
   - Root Directory: Leave empty if your Dockerfile is in the root directory
   - Plan: Select the Free plan or any other plan that suits your needs

4. **Environment Variables**:
   - Click on "Advanced" and add the following environment variables:
     - `SPRING_PROFILES_ACTIVE`: `prod`

5. **Database Configuration**:
   - The application is already configured to use a Railway PostgreSQL database
   - No additional database setup is required as the connection details are in application-prod.yml

6. **Deploy**:
   - Click "Create Web Service" to start the deployment process.
   - Render will build and deploy your application automatically.

### Alternative: Using render.yaml

If you've included the `render.yaml` file in your repository, you can use Render Blueprints for deployment:

1. Go to https://dashboard.render.com/blueprints
2. Click on "New Blueprint Instance"
3. Connect your GitHub repository
4. Render will automatically detect the `render.yaml` file and set up all services as defined

### Troubleshooting

- If you encounter any issues during deployment, check the build logs in the Render dashboard.
- Make sure your application is configured to use the environment variables defined in `application-prod.yml`.
- Ensure your Dockerfile is correctly set up to build and run your Spring Boot application.

### Accessing Your Application

Once deployed, your application will be available at the URL provided by Render, typically in the format `https://fanla-app.onrender.com`.
