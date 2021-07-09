output "crypto_rest_api_id" {
  value = aws_api_gateway_rest_api.crypto_api.id
}

output "crypto_rest_api_path" {
  value = aws_api_gateway_resource.crypto_api_resource.path
}
