package com.baizitech.common.selector;

import com.baizitech.common.configure.BaizitechAuthExceptionConfigure;
import com.baizitech.common.configure.BaizitechOAuth2FeignConfigure;
import com.baizitech.common.configure.BaizitechServerProtectConfigure;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class BaizitechCloudApplicationSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{
                BaizitechAuthExceptionConfigure.class.getName(),
                BaizitechOAuth2FeignConfigure.class.getName(),
                BaizitechServerProtectConfigure.class.getName()
        };
    }
}
