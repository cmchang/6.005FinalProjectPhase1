package pingball;

/**

 * 
 * DATATYPE DEFINITION.
 * 
 *Expression = Literal(value:boolean) + And(left:Expr, right:Expr)
 * 
 */
public interface Grammar {
    public boolean evaluate();
}



