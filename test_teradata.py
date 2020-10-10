# # -*- coding: utf-8 -*-
from teradataml import *

connection_name = create_context(host = "", username="be_tuskegee", password = "be_tuskegee")

df = DataFrame("BAG_SCAN_DETAILS")

for i in df
	print (i)

remove_context()