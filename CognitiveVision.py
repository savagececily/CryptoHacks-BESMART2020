# CryptoHacks - BE Smart 2020
# File Name CognitiveVision.py

from azure.cognitiveservices.vision.computervision import ComputerVisionClient
from azure.cognitiveservices.vision.computervision.models import OperationStatusCodes 
from azure.cognitiveservices.vision.computervision.models import VisualFeatureTypes 
from msrest.authentication import CognitiveServicesCredentials

from array import array
import os
from PIL import Image
import sys
import time

# Add your Computer Vision subscription key to your environment variables.
if '220f315b4a95497fa97fa448ab1a4e1d' in os.environ:
    subscription_key = os.environ['220f315b4a95497fa97fa448ab1a4e1d']
else:
    print("\nSet the 220f315b4a95497fa97fa448ab1a4e1d environment variable.\n**Restart your shell or IDE for changes to take effect.**")
    sys.exit()
# Add your Computer Vision endpoint to your environment variables.
if 'https://cyrptocomputervision.cognitiveservices.azure.com/' in os.environ:
    endpoint = os.environ['https://cyrptocomputervision.cognitiveservices.azure.com/']
else:
    print("\nSet the https://cyrptocomputervision.cognitiveservices.azure.com/ environment variable.\n**Restart your shell or IDE for changes to take effect.**")
    sys.exit()