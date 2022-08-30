rm(list = ls())

library(testthat)
library(digest)
library(stringr)


## QUESTION 1
head(quakes)
eq_df = quakes
head(eq_df)

lat = eq_df$lat
long = eq_df$long
depth = eq_df$depth
mag = eq_df$mag

xbar = mean(mag); xbar
s = sd(mag); s
m = median(mag); m

ans = (m/xbar); ans

mag_Z = (mag - xbar)/s; mag_Z

zbar = mean(mag_Z); zbar
s = sd(mag_Z); s

table(mag_Z>= -3 & mag_Z <= 3)[2]
ans = as.double(table(mag_Z>= -3 & mag_Z <= 3)[2]) / length(mag_Z); ans
typeof(ans)

## QUESTION 2

a1 = c(2,2,2,2)
a2 = c(2,4,6,8)
a3 = c(3,3,3,3)
A = matrix(c(a1, a2, a3), 3, 4, T) # matrix(data, nrow, ncol, byrow = T)
A
# or matrix(c(2,2,2,2,2,4,6,8,3,3,3,3), 3, 4, byrow = T)

b = 1:12
B = matrix(b, 4, 3, T) # matrix(data, nrow, ncol, byrow = T)
B

C = t(A) + B; C

D = A %*% B; D

## QUESTION 3

?airquality
air = airquality
head(air)

ans = c(nrow(air), ncol(air)); ans

ans = table(is.na(air)); ans

