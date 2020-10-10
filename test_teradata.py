# # -*- coding: utf-8 -*-
from teradataml import *

try:
	connection_name = create_context(host = "http://tdchackathon1.eastus.cloudapp.azure.com/", username="be_tuskegee", password = "be_tuskegee")

	df = DataFrame.from_table("BAG_SCAN_DETAILS")

	df
	remove_context()
except:
	remove_context()
