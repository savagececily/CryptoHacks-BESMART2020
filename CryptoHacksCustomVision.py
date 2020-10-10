# # -*- coding: utf-8 -*-
# CryptoHacks - BE Smart 2020
# File Name CognitiveVision.py

from msrest.authentication import ApiKeyCredentials
from azure.cognitiveservices.vision.customvision.prediction import CustomVisionPredictionClient
from msrest.authentication import ApiKeyCredentials

ENDPOINT = "https://cryptohacks-cognitiveservice.cognitiveservices.azure.com/"

publish_iteration_name = "PublishCryptoHacks1"
project = "CryptoHacks-CustomVision"

# Replace with a valid key
training_key = "ecf0252f958e4709bdb832c0899af10a"
prediction_key = "3f1075b5976543b4849d06c844335bdd"
prediction_resource_id = "</subscriptions/ca569c5c-70e8-42b6-9a70-6097b4146dcf/resourceGroups/CyrptoHacksRG/providers/Microsoft.CognitiveServices/accounts/CryptoHacks-CognitiveService"


# Now there is a trained endpoint that can be used to make a prediction
prediction_credentials = ApiKeyCredentials(in_headers={"Prediction-key": prediction_key})
predictor = CustomVisionPredictionClient(ENDPOINT, prediction_credentials)

#with open(base_image_url + "images/Test/test_image.jpg", "rb") as image_contents:
results = predictor.classify_image(project.id, publish_iteration_name, image_contents.read())

# Display the results.
for prediction in results.predictions:
	print("\t" + prediction.tag_name +
              ": {0:.2f}%".format(prediction.probability * 100))