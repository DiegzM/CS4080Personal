class FloatQueue:
    def __init__(self):
        self.items = []

    def is_empty(self):
        return len(self.items) == 0

    def enqueue(self, item: float):
        if (not isinstance(item, float)):
            raise ValueError("Only float values can be enqueued")
        self.items.append(item)

    def dequeue(self) -> float:
        if self.is_empty():
            raise IndexError("Dequeue from empty queue")
        return self.items.pop(0)

    def size(self) -> int:
        return len(self.items)
    
q = FloatQueue()
q.enqueue(1.1)
q.enqueue(2.2)
q.enqueue(3.3)

print("\n---------------------\n")
print("Initial Queue Size:", q.size())
print("Dequeue:", q.dequeue())
print("Queue Size after Dequeue:", q.size())
print("Is Queue Empty?:", q.is_empty())
print()
q.enqueue(4.4)
print("Queue Size after Enqueue:", q.size())
print("Dequeue:", q.dequeue())
print("Dequeue:", q.dequeue())
print("Dequeue:", q.dequeue())
print("Is Queue Empty after all Dequeues?:", q.is_empty())
print()