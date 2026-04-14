from random import random, randint

def mcsOn3(X): 
    '''This is the O(n^3) algorithm for maximum contiguous subarray problem.
    In simple terms, it is a brute-force algorithm that checks all possible subarrays and calculates their sums to find the maximum sum.
    So it basically iterates through all possible starting and ending points of subarrays, calculates the sum of each subarray, and keeps track of the maximum sum found.'''

    n = len(X)
    maxsofar = 0
    for low in range(n): # [0,n) - low is the starting point of the subarray
        for high in range(low, n): # [low,n)
            sum = 0
            for r in range(low, high): # [low,high)
                sum += X[r]
            if (sum > maxsofar):
                maxsofar = sum
    return maxsofar 

if __name__ == "__main__":

    # Generate a random array of integers
    n = 6  # Size of the array
    X = [1, -2, 3, 4, -5, 8]
    
    print("Array:", X)
    result = mcsOn3(X)
    print("Maximum contiguous subarray sum:", result)