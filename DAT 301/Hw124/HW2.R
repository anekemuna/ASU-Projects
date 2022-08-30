rm(list = ls())

library(testthat)
library(digest)
library(stringr)

## QUESTION 1

data(Orange)
orange_df = Orange
tree = orange_df$Tree
age = orange_df$age
circ = orange_df$circumference

xbar  = round(mean(circ), 2); xbar
circ_Mean = lapply(split(circ,age), mean); circ_Mean

ans = length(split(orange_df, age == 118 & circ >= 31)); ans # or 'sum(with(orange_df,age == 118 & circ >= 31))'
                     
# mthd 1
# iqr118 = IQR(subset(circ, age == 118)); iqr118
# iqr664 = IQR(subset(circ, age == 664)); iqr664
# iqr1231 = IQR(subset(circ, age == 1231)); iqr1231

# mthd 2
# s = split(circ,age)
# iqr118 = IQR(s$`118`); iqr118
# iqr664 = IQR(s$`664`); iqr664
# iqr1231 = IQR(s$`1231`); iqr1231

# mthd 3
iqrList = lapply(split(circ,age), IQR)
iqr118 = iqrList$`118`; iqr118
iqr664 = iqrList$`664`; iqr664
iqr1231 = iqrList$`1231`; iqr1231

s = split(circ, age)
Q = quantile(s$`664`, probs = seq(0,1,by = 0.25), name = F); Q
upperfence = Q[4] + (1.5 * iqr664); upperfence
lowerfence = Q[2] - (1.5 * iqr664); lowerfence

## QUESTION 2

set.seed(1234)
xNorm = rnorm(n = 10,mean = 100,sd = 20); xNorm

m = 100; s = 20;
fNorm = function(x, m, s) {
  (x - m) / s
}

zNorm = fNorm(xNorm, m, s); zNorm

set.seed(1234)
xBin = rbinom(n = 10, size = 30, prob = 0.3); xBin
m = 30 * 0.3; s = sqrt(30 * 0.3 * (1-0.3))
bNorm = fNorm(xBin, m, s); bNorm

zMean = round(mean(zNorm), 2); zMean
zS = round(sd(zNorm), 2); zS
bMean = round(mean(bNorm), 2); bMean
bS = round(sd(bNorm), 2); bS

## QUESTION 3
carsMeans = apply(cars,2,mean); carsMeans

## QUESTION 4
intType = function(x){
  n = length(x)
  result = rep(0,n)
  for(i in 1:n)
  {
    if( x[i] %% 1 == 0)
    {
      if(x[i] %% 2 == 0)
      {
        result[i]= "Even"
      }
      else
      {
        result[i] = "Odd"
      }
    }
    else
    {
      result[i] = "Non-integer"
    }
  }
  
  return(result)
}

intType(c(3.4, 3, 5, 6, 9, 12))

