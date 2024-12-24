abstract class Expr {
    interface Visitor<R> {
      R visitBinaryExpr(Binary expr);
    }
  
    abstract <R> R accept(Visitor<R> visitor);
  
    static class Binary extends Expr {
      final Expr left;
      final Token operator;
      final Expr right;
  
      Binary(Expr left, Token operator, Expr right) {
        this.left = left;
        this.operator = operator;
        this.right = right;
      }
  
      @Override
      <R> R accept(Visitor<R> visitor) {
        return visitor.visitBinaryExpr(this);
      }
    }
  }
  
  interface PastryVisitor {
      void visitBeignet(Beignet beignet); 
      void visitCruller(Cruller cruller);
  }
  
  abstract class Pastry {
      abstract void accept(PastryVisitor visitor);
  }
  
  class Beignet extends Pastry {
      @Override
      void accept(PastryVisitor visitor) {
          visitor.visitBeignet(this);
      }
  }
  
  class Cruller extends Pastry {
      @Override
      void accept(PastryVisitor visitor) {
          visitor.visitCruller(this);
      }
  }
  