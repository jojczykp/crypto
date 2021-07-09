provider "aws" {
  region                      = var.region
  access_key                  = var.accessKey
  secret_key                  = var.secretKey
  skip_credentials_validation = true
  skip_metadata_api_check     = true
  skip_requesting_account_id  = true
  s3_force_path_style         = true
  endpoints {
    iam        = "http://localhost:4566"
    lambda     = "http://localhost:4566"
    apigateway = "http://localhost:4566"
  }
}
