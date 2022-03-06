# 一键自动生成所有子模块的 javadoc 文档
# ------------------------------------------------
# 示例：
#   ./bin/gen_javadoc.ps1
# ------------------------------------------------

Write-Output "Generate javadoc-jar for all modules ..."
mvn clean package

$items = Get-ChildItem . "exp-libs-*"
Foreach($item in $items) {
    Write-Output "Generate javadoc for $item ..."
    $srcFile = Get-ChildItem "./$item/target" "*-javadoc.jar"
    $srcPath = "./$item/target/$srcFile"

    If(Test-Path $srcPath) {
        $snkPath = "./$item/target/$item.zip"
        Copy-Item -Path "$srcPath" -Destination "$snkPath"
        $srcPath = $snkPath

        If(Test-Path $srcPath) {
            $snkPath = "./docs/javadocs/$item"
            If(Test-Path $snkPath) {
                Remove-Item -Path "$snkPath" -Recurse
            }
            Expand-Archive -Path "$srcPath" -DestinationPath "$snkPath"
        }
    }
}
Write-Output "Done ."
