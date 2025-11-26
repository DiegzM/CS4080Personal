class Matrix:
    def __init__(self, rows, cols):
        self.rows = rows
        self.cols = cols
        self.data = [[0 for _ in range(cols)] for _ in range(rows)]
    
    def add(self, other):
        if self.rows != other.rows or self.cols != other.cols:
            raise ValueError("Matrices must have the same dimensions to add.")
        
        result = Matrix(self.rows, self.cols)
        for i in range(self.rows):
            for j in range(self.cols):
                result.data[i][j] = self.data[i][j] + other.data[i][j]
        return result
    
    def subtract(self, other):
        if self.rows != other.rows or self.cols != other.cols:
            raise ValueError("Matrices must have the same dimensions to subtract.")
        
        result = Matrix(self.rows, self.cols)
        for i in range(self.rows):
            for j in range(self.cols):
                result.data[i][j] = self.data[i][j] - other.data[i][j]
        return result
    
    def multiply(self, other):
        if self.cols != other.rows:
            raise ValueError("Number of columns of the first matrix must equal number of rows of the second matrix.")
        
        result = Matrix(self.rows, other.cols)
        for i in range(self.rows):
            for j in range(other.cols):
                for k in range(self.cols):
                    result.data[i][j] += self.data[i][k] * other.data[k][j]
        return result
    

m1 = Matrix(2, 2)
m2 = Matrix(2, 2)

m1.data = [[1, 2], [3, 4]]
m2.data = [[5, 6], [7, 8]]

print("\n---------------------\n")
print("Matrix 1:" , m1.data)
print("Matrix 2:" , m2.data)
print("\n---------------------\n")
print("\033[1mADDITION\033[0m")
m3 = m1.add(m2)
print(f"M1 + M2 = \033[1m{m3.data}\033[0m")
print("\n---------------------\n")
print("\033[1mSUBTRACTION\033[0m")
m4 = m1.subtract(m2)
print(f"M1 - M2 = \033[1m{m4.data}\033[0m")
print("\n---------------------\n")
print("\033[1mMULTIPLICATION\033[0m")
m5 = m1.multiply(m2)
print(f"M1 * M2 = \033[1m{m5.data}\033[0m")
print()

