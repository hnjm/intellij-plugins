/*
 * Copyright 2009 The authors
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.intellij.struts2.dom.struts.constant;

import com.intellij.openapi.module.Module;
import com.intellij.struts2.model.constant.StrutsConstant;
import com.intellij.struts2.model.constant.StrutsConstantManager;
import com.intellij.util.Function;
import com.intellij.util.containers.ContainerUtil;
import com.intellij.util.xml.ConvertContext;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Collections;

/**
 * @author Yann C&eacute;bron
 */
public class ConstantNameConverterImpl extends ConstantNameConverter {

  private static final Function<StrutsConstant, String> CONSTANT_NAME_FUNCTION = new Function<StrutsConstant, String>() {
    public String fun(final StrutsConstant strutsConstant) {
      return strutsConstant.getName();
    }
  };

  @NotNull
  public Collection<? extends String> getVariants(final ConvertContext context) {
    final Module module = context.getModule();
    if (module == null) {
      return Collections.emptyList();
    }

    final StrutsConstantManager constantManager = StrutsConstantManager.getInstance(module.getProject());
    return ContainerUtil.map(constantManager.getConstants(module), CONSTANT_NAME_FUNCTION);
  }

}