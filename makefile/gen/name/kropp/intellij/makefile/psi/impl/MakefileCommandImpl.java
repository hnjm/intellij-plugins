// This is a generated file. Not intended for manual editing.
package name.kropp.intellij.makefile.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import name.kropp.intellij.makefile.psi.MakefileCommand;
import name.kropp.intellij.makefile.psi.MakefileFunction;
import name.kropp.intellij.makefile.psi.MakefileVariableUsage;
import name.kropp.intellij.makefile.psi.MakefileVisitor;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MakefileCommandImpl extends ASTWrapperPsiElement implements MakefileCommand {

  public MakefileCommandImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull MakefileVisitor visitor) {
    visitor.visitCommand(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof MakefileVisitor) accept((MakefileVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<MakefileFunction> getFunctionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, MakefileFunction.class);
  }

  @Override
  @NotNull
  public List<MakefileVariableUsage> getVariableUsageList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, MakefileVariableUsage.class);
  }

}
