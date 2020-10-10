
ch = []
nums = []
ch = list(map(str,input()))
for i in range(10):
    nums.append(str(i))
count = 0
new_nums = []
for i in ch:

    if i in nums:
        new_nums.append(int(i))
        ch.pop(count)
    count += 1


new_nums = sum(new_nums)
ch.sort()

print("".join(ch)+str(new_nums))
