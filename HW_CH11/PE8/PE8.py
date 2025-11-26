class PriorityQueue:
    def __init__(self):
        self._queue = []

    def enqueue(self, string: str, priority: int):
        if len(string) > 20:
            string = string[:20]
        elif len(string) < 20:
            string = string + ' ' * (20 - len(string))
        self._queue.append((priority, string))

    def dequeue(self) -> str:
        if self.is_empty():
            raise IndexError("Dequeue from empty priority queue")
        self._queue.sort(key=lambda x: x[0])
        return self._queue.pop(0)[1].strip()
    
    def is_empty(self) -> bool:
        return len(self._queue) == 0
    
pq = PriorityQueue()
pq.enqueue("task1", 2)
pq.enqueue("task2", 1)
pq.enqueue("a very long task name that exceeds twenty characters", 3)
print("\n---------------------\n")
print("Dequeue:", pq.dequeue())
print("Dequeue:", pq.dequeue())
print("Dequeue:", pq.dequeue())
print()
print("Is Priority Queue Empty after all Dequeues?:", pq.is_empty())
print()
