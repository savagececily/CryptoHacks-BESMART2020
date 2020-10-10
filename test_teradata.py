# # -*- coding: utf-8 -*-
from teradataml import *

connection_name = create_context(host = "", username="be_tuskegee", password = "be_tuskegee")

df = DataFrame("SOME_VIEW")

for i in df
	print (i)

remove_context()