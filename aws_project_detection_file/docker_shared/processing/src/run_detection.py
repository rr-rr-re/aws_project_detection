import sys
sys.path.append('site-packagesのパス')
from skimage import data, io, filters, color, img_as_ubyte
from sklearn import preprocessing
import numpy as np
import matplotlib.pyplot as plt
import scipy
import Cython

# C++で作成した共有ファイルの.soをインポート
import face_detection

input_path = '/media/docker_shared/mono_develop/img/getImg.jpg'
output_path = '/media/docker_shared/mono_develop/img/kansei.jpg'
# /Users/ruimac/opt/anaconda3/bin/python

try :
    
    result_c_img = face_detection.face_detect()

except:
    print('Error')

else:
    print("finish (no error)")
