# # -*- coding: utf-8 -*-
from teradataml import *

connection_name = create_context(host = "http://tdchackathon1.eastus.cloudapp.azure.com/", username="be_tuskegee", password = "be_tuskegee")

df = DataFrame.from_table("BAG_SCAN_DETAILS")

for i in df
	print (i)

remove_context()