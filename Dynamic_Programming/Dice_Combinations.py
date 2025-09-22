MOD = 10 ** 9 + 7
n = int(input())
dp = [0] * (n + 1)
dp[0] = 1

for i in range(1, n + 1):
    for j in range(1, 7):
        dp[i] += dp[i - j] if i - j >= 0 else 0
        dp[i] %= MOD
        
print(dp[n])