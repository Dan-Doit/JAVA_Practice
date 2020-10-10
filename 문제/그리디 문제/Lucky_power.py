
nums = []
nums = list(map(int,input()))

half = len(nums)//2
left = 0
right = 0
for i in range(half):
    left += nums[i]
for i in range(half,len(nums)):
    right += nums[i]

if right == left:
    print("LUCKY")
else:
    print("READY")
