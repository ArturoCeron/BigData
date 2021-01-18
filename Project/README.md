<div align="center">

**TECNOLÓGICO NACIONAL DE MÉXIO**

INSTITUTO TECNOLÓGICO DE TIJUANA

SUBDIRECCIÓN ACADÉMICA
 
DEPARTAMENTO DE SISTEMAS Y COMPUTACIÓN
 
SEMESTRE SEPTIEMBRE 2020 – ENERO 2021

INGENIERÍA EN SISTEMAS COMPUTACIONALES

 
 [![](https://upload.wikimedia.org/wikipedia/commons/2/2e/ITT.jpg)](https://upload.wikimedia.org/wikipedia/commons/2/2e/ITT.jpg)

JOSÉ CHRISTIAN ROMERO HERNÁNDEZ

DATOS MASIVOS
BDD-1704 SC9A, L - V 18:00 - 19:00 (91L4/0308)


**FINAL PROJECT**


**STUDENTS**

BERNARDINO MARTINEZ JERONIMO 14212334

CERON URIBE ARTURO 1721150676


Tijuana, Baja California, al 07 de enero de 2021.
 
</div>

# Index

### [Introduction](#intro)
### [Algorithms used](#algorithms)

 - [SVM](#svm)
 - [DTC](#dtc)
 - [LR](#lr)
 - [MLPC](#mlpc)
 
### [Implementation](#implement)
### [Results](#result)
### [Conclusion](#conclusions)
### [References](#reference)


## Introduction <a name="intro"></a>

<div align="justify">
This document specifies the analysis and development of the final project of unit 4 of the matter of big data, which the objective of this final project is to compare the Machine Learning performance algorithms that were seen during the semester.
The Bank Marketing data set obtained from the following source will be used
 
<div align="center"> https://archive.ics.uci.edu/ml/datasets/Bank+Marketing </div>

The implementation of these algorithms is explained, as well as the result that was reached, through a tabulation to better visualize the performance of each one of them.
</div>

## Algorithms used <a name="algorithms"></a>

### SVM - Support Vector Machine <a name="svm"></a>
<div align="justify">A support vector machine (SVM) is a supervised learning algorithm that can be used for binary classification or regression. Support vector machines are very popular in applications such as natural language processing, speech, image recognition, and computer vision.
 
A support vector machine constructs an optimal hyperplane in the form of a decision surface, so that the margin of separation between the two classes in the data is maximally widened. Support vectors refer to a small subset of the training observations that are used as support for the optimal location of the decision surface.
Support vector machines belong to a class of Machine Learning algorithms called kernel methods and are also known as kernel machines.
Support vector machine training consists of two phases
 
* Transform the predictors (input data) into a highly dimensional feature space. In this phase it is enough to specify the kernel; data is never explicitly transformed into feature space. This process is commonly known as the kernel hack.
* Solve a quadratic optimization problem that fits an optimal hyperplane to classify the transformed characteristics into two classes. The number of transformed features is determined by the number of support vectors. [1]

</div>

<p align="center">
<img src="https://github.com/ArturoCeron/BigData/blob/Project/Project/documentation/SVM.png">
</p>


### DTC - Decision Tree Classifier <a name="dtc"></a>
<div align="justify">
In decision analysis, a decision tree can be used to visually and explicitly represent decisions and decision making. As its name implies, it uses a decision model in the form of a tree.

Although it is a commonly used tool in data mining to derive a strategy to reach a particular goal, it is also widely used in machine learning. A decision tree is drawn upside down with its root at the top. In the image to the left, the bold black text represents an internal node / condition, according to which the tree is divided into branches / edges.

The end of the branch that is no longer divided is the decision / leaf, in this case, whether the passenger died or survived, represented as red and green text respectively. It is a tree-structured classifier, where the internal nodes represent the characteristics of a data set, the branches represent the decision rules, and each leaf node represents the result.

In a decision tree, there are two nodes, which are the decision node and the leaf node. Decision nodes are used to make any decision and have multiple branches, while leaf nodes are the result of those decisions and contain no more branches. Decisions or testing are made based on the characteristics of the given data set. [2]
</div>

<p align="center">
<img src="https://github.com/ArturoCeron/BigData/blob/Project/Project/documentation/dtc.png">
</p>


### LR - Logistic Regression <a name="lr"></a>
<div align="justify">
Logistic Regression or Logistic Regression is a classification algorithm used to predict the probability of a categorical dependent variable. In logistic regression, the dependent variable is a binary variable that contains data coded as 1 - 0, yes - no, open - closed, etc.

This binary logistic model is used to estimate the probability of a binary response based on one or more predictor or independent variables. Lets say that the presence of a risk factor increases the probability of a given result by a specific percentage.

Like all regression analyzes, logistic regression is a predictive analysis. It is used to describe data and explain the relationship between a dependent binary variable and one or more nominal, ordinal, interval, or ratio-level independent variables.
Logistic regression requires fairly large sample sizes.
The reason why logistic regression is widely used, despite advanced algorithms like deep neural networks, is because it is very efficient and does not require too many computational resources that make it affordable to run production.

Some of the characteristics that you should consider for this algorithm are the following

* Binary output variable. This may be obvious, but logistic regression is intended for binary (two-class) classification problems. It will predict the probability that an instance belongs to the default class, which can be divided into a classification of 0 or 1.
* Eliminate noise. The logistic regression does not assume any error in the output variable (y). Consider removing outliers and possibly the highest ranked instances of your training data.
* Gaussian distribution. Logistic regression is a linear algorithm, with a non-linear transformation at the output. Data transformations of your input variables that better expose this linear relationship can result in a more accurate model.
* Remove correlated entries. Like linear regression, the model can be overfitted if it has multiple highly correlated inputs. Let's consider calculating the pairwise correlations between all inputs and eliminating highly correlated inputs.

It cannot converge. The expected probability estimation process may learn that the coefficients do not converge, this can happen if there are many highly correlated entries in your data, or if the data is very sparse. [3]
</div>

<p align="center">
<img src="https://github.com/ArturoCeron/BigData/blob/Project/Project/documentation/lr.jpg">
</p>


### MLPC - Multilayer Perceptron Classifier <a name="mlpc"></a>
<div align="justify">
 
A multilayer perceptron (MLP) is a deep, artificial neural network. It is composed of more than one perceptron. They are composed of an input layer to receive the signal, an output layer that makes a decision or prediction about the input, and in between those two, an arbitrary number of hidden layers that are the true computational engine of the MLP. MLPs with one hidden layer are capable of approximating any continuous function.

Multilayer perceptrons are often applied to supervised learning problems: they train on a set of input-output pairs and learn to model the correlation (or dependencies) between those inputs and outputs. Training involves adjusting the parameters, or the weights and biases, of the model in order to minimize error. Backpropagation is used to make those weigh and bias adjustments relative to the error, and the error itself can be measured in a variety of ways, including by root mean squared error (RMSE). 

In the forward pass, the signal flow moves from the input layer through the hidden layers to the output layer, and the decision of the output layer is measured against the ground truth labels.

In the backward pass, using backpropagation and the chain rule of calculus, partial derivatives of the error function w.r.t. the various weights and biases are back-propagated through the MLP. That act of differentiation gives us a gradient, or a landscape of error, along which the parameters may be adjusted as they move the MLP one step closer to the error minimum. This can be done with any gradient-based optimisation algorithm such as stochastic gradient descent. The network keeps playing that game of tennis until the error can go no lower. This state is known as convergence. [4]

</div>

<p align="center">
<img src="https://github.com/ArturoCeron/BigData/blob/Project/Project/documentation/mlcp.png">
</p>

## Implementation <a name="implement"></a>

<div align="justify">We only used two technologies

* Scala
* Spark

We used *Scala* for developing the code needed for the programs, and *Spark* for the libraries that we used in order to read the csv file, get the data, manipulate it, clean it and implement the machine learning methods.
Each one of them were highly useful to let us execute the programs, test them, get the results and finally compare each one other.
</div>
 
## Results <a name="result"></a>

<table class="egt" border="0">
<tr>
  <td> Averages </td>
    <td> Used memory (MB)</td>
    <td>Time (s)</td>
    <td> Accuracy (%)</td>
    <td>Error (%)</td>
  </tr>
  <tr>
    <td>MLCP</td>
    <td>365.9</td>
    <td>14.64</td>
    <td>84.14</td>
    <td>15.86</td>
  </tr>
    <tr>
    <td>LR</td>
    <td>299.6</td>
    <td>8.42</td>
    <td>84.27</td>
    <td>15.73</td>
  </tr>
    <tr>
    <td>SVM</td>
    <td>351.4</td>
    <td>11.78</td>
    <td>84.07</td>
    <td>15.93</td>
  </tr>
   <tr>
    <td>DTC</td>
    <td>377.3</td>
    <td>10.03</td>
    <td>84.19</td>
    <td>15.81</td>
  </tr>
</table>

<div align="justify">
As we can see, the results show us that the most accurate method was Logistic Regression, followed by Decision Tree Classifier and the ones with the highest error rate were Support Vector Machine and Multilayer Perceptron Classifier.
 
We can also see that the one method that used the most amount of memory was the Decision Tree Classifier, and the one that needed less memory was Logistic Regression.
Finally the method with the best timing was Logistic Regression and the worst was Multilayer Perceptron Classifier.

So, based on our tests we can conclude this

</div>

Best method with higher accuracy, less amount of memory needed and best timing: **Logistic Regression**

But that doesn't mean that the others are less powerful, this decision was based just in 10 iterations of the code, many other circumstances can change the decision to choose any other method.


## Conclusion <a name="conclusions"></a>
<div align="justify">
As a conclusion during the semester of the Big Data subject, we saw that there is a great difference in models for data prediction, when making certain use of the models they will show us their advantages and disadvantages, each model giving what we require with a certain degree of accuracy in each prediction.

In this document we present some of the algorithms that we saw during the semester, with this document we have reached a deeper understanding of how algorithms work when using them with large data sets to reach the information we are looking for, by analyzing all these algorithms we realize how efficient each other can be.
</div>

## References <a name="reference"></a>

[1] JavaTpoint. (2018). Support Vector Machine Algorithm. 23/12/2020, de JavaTpoint Sitio web: 
https://www.javatpoint.com/machine-learning-support-vector-machine-algorithm

[2] JavaTpoint. (2018). Decision Tree Classification Algorithm. 23/12/2020, de JavaTpoint Sitio web: 
https://www.javatpoint.com/machine-learning-decision-tree-classification-algorithm

[3] Selva Prabhakaran. Logistic Regression – A Complete Tutorial With Examples in R. 23/12/2020, de machine learning plus Sitio web: 
https://www.machinelearningplus.com/machine-learning/logistic-regression-tutorial-examples-r/

[4] Chris Nicholson. A Beginner's Guide to Multilayer Perceptrons (MLP). 27/12/2020, de pathmind Sitio web: 
https://wiki.pathmind.com/multilayer-perceptron


