# kNN and Performance Measures
The **k-Nearest Neighbors (kNN)** algorithm is a simple, non-parametric supervised learning method used for 
classification and regression. It works by identifying the `k` closest data points (neighbors) to a query point in the 
feature space and making predictions based on the majority class (for classification) or the average value 
(for regression) of these neighbors. kNN relies on distance metrics like Euclidean distance and is intuitive but 
computationally intensive for large datasets.

To work with kNN the following imports should be helpful:
```
from sklearn.model_selection import train_test_split    # data splitting
from sklearn.preprocessing import MinMaxScaler          # data scaling
from sklearn.metrics import roc_curve, roc_auc_score    # performance measures    
from sklearn.metrics import precision_recall_curve
from sklearn.metrics import confusion_matrix,f1_score,precision_score,recall_score,accuracy_score,average_precision_score
from sklearn.neighbors import KNeighborsClassifier      # classifier
```
