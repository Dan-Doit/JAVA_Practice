
import heapq

def min_num(nums,k):
    heap = []

    for num in nums:
        heapq.heappush(heap,num)

    mins = None
    for i in range(k):
        mins = heapq.heappop(heap)
    return mins

print(min_num([1,5,4,2,6,3],3))


def max_num(nums,k):
    heap = []

    for num in nums:
        heapq.heappush(heap,(-num,num))

    maxs = None
    for i in range(k):
        # 1번 인덱스를 maxs 에 저장
        maxs = heapq.heappop(heap)[1]
    return maxs

print(max_num([1,5,4,2,6,3],3))


def sort_num(nums):
    heap = []

    for num in nums:
        heapq.heappush(heap,num)

    sortt = []
    for i in range(len(nums)):
        sortt.append((heapq.heappop(heap)))
    return sortt

print(sort_num([1,5,4,2,6,3]))
