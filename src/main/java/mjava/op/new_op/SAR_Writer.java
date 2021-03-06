package mjava.op.new_op;

import com.github.javaparser.ast.expr.MethodCallExpr;
import mjava.op.record.TraditionalMutantCodeWriter;
import mjava.op.record.WriteJavaFile;

import java.io.File;
import java.io.PrintWriter;

/**
 * Created by user on 2018/9/5.
 * @author Jian Liu
 */
public class SAR_Writer extends TraditionalMutantCodeWriter {
    MethodCallExpr original;

    MethodCallExpr mutant;

    public SAR_Writer(String file_name, PrintWriter out) {
        super(file_name, out);
    }

    /**
     * Set original source code and mutated code
     */
    public void setMutant(MethodCallExpr exp1, MethodCallExpr exp2) {
        original = exp1;
        mutant = exp2;
    }

    /**
     * Log mutated line
     */
    public void writeFile( File original_file )
    {
        new WriteJavaFile(original_file,out).writeFile(original,mutant);
        mutated_start = line_num =original.getBegin().get().line;
        //System.out.println("start: "+mutated_start);
        String log_str =original.toString()+ "  =>  " +mutant.toString();
        writeLog(removeNewline(log_str));
    }
}
