# -*- coding: utf-8 -*-
"""
Created on Tue Mar 19 22:47:08 2019

@author: wuersch
"""

import pickle
from sklearn.datasets import fetch_mldata


mnist = fetch_mldata('MNIST original')

filename='MNIST-original.pkl'

filehandler = open(filename, 'wb') 
pickle.dump(mnist, filehandler)
filehandler.close()

filehandler = open(filename, 'rb') 
mnist2 = pickle.load(filehandler)
filehandler.close()