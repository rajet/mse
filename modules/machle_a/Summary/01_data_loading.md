# Data loading
Just to load some data and show them as plots, there are two imports necessary: \
```
import pandas as pd
import matplotlib.pyplot as plt
```
After that you can load a file into a variable using the ``read_csv`` method
```
df = pd.read_csv('nba_stats.csv', low_memory=False)
df.head()       # Shows the first items 
df.tail()       # Shows the last items
df.info()       # Shows all existing columns with informations for each of them
df.describe()   # Shows the informations as count, mean, std, min, ...
df.shape()      # Gives you an "array" with rows and columns as integer -> (20002, 32), so df.shape()[x] can have 0,1
```
## Column selection
Columns can be selected in different ways.
```
df[cols]            # cols should be an array of string: cols = ["col1", "col2", "col3"]
df[0:5]             # You can define a length which will be loaded 
df.loc[0:5, ["CRASH DATE", "BOROUGH", "NUMBER OF PERSONS INJURED"]] # select row and columns by name
df.iloc[[1,4][0:3]] # select row and column by position
```
## Boolean indexing
Rows can be filtered out by using booleans
```
boolean_condition = (df["col1"] <- xx) & (df["col2"] > yy))
df_filtered = df[boolean_condition]
```
This is an example how to load data getting data filtered by year and get mean of it:
```
df.loc[df["Year"] == 2017]["Age"].mean()
```
## Filtering content, group by column and plot it
```
filtered_df = df[df["Year"] > 2000]
points_per_year = filtered_df.groupby("Year")["PTS"].sum()
points_per_year.plot(kind="bar", title="Total Points Per Year Since 2000", figsize=(10, 6))

plt.xlabel("Year")
plt.ylabel("Total Points (PTS)")
plt.xticks(rotation=45)
plt.grid(axis="y", linestyle="--", alpha=0.7)
plt.show()
```
To get the year with the most players, there can be used the following code:
```
players_per_year.idmax()    # get the year from the row with the highest players
players_per_year.max()      # get the row with the most players
```