package kotlin.io.path;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystemException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.SecureDirectoryStream;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;

/* compiled from: PathRecursiveFunctions.kt */
@Metadata(d1 = {"\u0000v\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a$\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0082\b¢\u0006\u0002\b\u0006\u001a\u001d\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002¢\u0006\u0002\b\n\u001a\u001d\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002¢\u0006\u0002\b\r\u001a&\u0010\u000e\u001a\u0004\u0018\u0001H\u000f\"\u0004\b\u0000\u0010\u000f2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u0005H\u0082\b¢\u0006\u0004\b\u0010\u0010\u0011\u001aw\u0010\u0012\u001a\u00020\t*\u00020\t2\u0006\u0010\u0013\u001a\u00020\t2Q\b\u0002\u0010\u0014\u001aK\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0013\u0012\u0017\u0012\u00150\u0019j\u0002`\u001a¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u001c0\u00152\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0007\u001a´\u0001\u0010\u0012\u001a\u00020\t*\u00020\t2\u0006\u0010\u0013\u001a\u00020\t2Q\b\u0002\u0010\u0014\u001aK\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0013\u0012\u0017\u0012\u00150\u0019j\u0002`\u001a¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u001c0\u00152\u0006\u0010\u001d\u001a\u00020\u001e2C\b\u0002\u0010 \u001a=\u0012\u0004\u0012\u00020!\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\"0\u0015¢\u0006\u0002\b#H\u0007\u001a\f\u0010$\u001a\u00020\u0001*\u00020\tH\u0007\u001a\u001b\u0010%\u001a\f\u0012\b\u0012\u00060\u0019j\u0002`\u001a0&*\u00020\tH\u0002¢\u0006\u0002\b'\u001a'\u0010(\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\t0)2\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002¢\u0006\u0002\b*\u001a'\u0010+\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\t0)2\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002¢\u0006\u0002\b,\u001a5\u0010-\u001a\u00020\u001e*\b\u0012\u0004\u0012\u00020\t0)2\u0006\u0010.\u001a\u00020\t2\u0012\u0010/\u001a\n\u0012\u0006\b\u0001\u0012\u00020100\"\u000201H\u0002¢\u0006\u0004\b2\u00103\u001a\u0011\u00104\u001a\u000205*\u00020\"H\u0003¢\u0006\u0002\b6\u001a\u0011\u00104\u001a\u000205*\u00020\u001cH\u0003¢\u0006\u0002\b6¨\u00067"}, d2 = {"collectIfThrows", "", "collector", "Lkotlin/io/path/ExceptionsCollector;", "function", "Lkotlin/Function0;", "collectIfThrows$PathsKt__PathRecursiveFunctionsKt", "insecureEnterDirectory", "path", "Ljava/nio/file/Path;", "insecureEnterDirectory$PathsKt__PathRecursiveFunctionsKt", "insecureHandleEntry", "entry", "insecureHandleEntry$PathsKt__PathRecursiveFunctionsKt", "tryIgnoreNoSuchFileException", "R", "tryIgnoreNoSuchFileException$PathsKt__PathRecursiveFunctionsKt", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "copyToRecursively", TypedValues.AttributesType.S_TARGET, "onError", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "source", "Ljava/lang/Exception;", "Lkotlin/Exception;", "exception", "Lkotlin/io/path/OnErrorResult;", "followLinks", "", "overwrite", "copyAction", "Lkotlin/io/path/CopyActionContext;", "Lkotlin/io/path/CopyActionResult;", "Lkotlin/ExtensionFunctionType;", "deleteRecursively", "deleteRecursivelyImpl", "", "deleteRecursivelyImpl$PathsKt__PathRecursiveFunctionsKt", "enterDirectory", "Ljava/nio/file/SecureDirectoryStream;", "enterDirectory$PathsKt__PathRecursiveFunctionsKt", "handleEntry", "handleEntry$PathsKt__PathRecursiveFunctionsKt", "isDirectory", "entryName", "options", "", "Ljava/nio/file/LinkOption;", "isDirectory$PathsKt__PathRecursiveFunctionsKt", "(Ljava/nio/file/SecureDirectoryStream;Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Z", "toFileVisitResult", "Ljava/nio/file/FileVisitResult;", "toFileVisitResult$PathsKt__PathRecursiveFunctionsKt", "kotlin-stdlib-jdk7"}, k = 5, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX, xs = "kotlin/io/path/PathsKt")
/* loaded from: classes.dex */
class PathsKt__PathRecursiveFunctionsKt extends PathsKt__PathReadWriteKt {

    /* compiled from: PathRecursiveFunctions.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[CopyActionResult.values().length];
            try {
                iArr[CopyActionResult.CONTINUE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[CopyActionResult.TERMINATE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[CopyActionResult.SKIP_SUBTREE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[OnErrorResult.values().length];
            try {
                iArr2[OnErrorResult.TERMINATE.ordinal()] = 1;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr2[OnErrorResult.SKIP_SUBTREE.ordinal()] = 2;
            } catch (NoSuchFieldError e5) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public static /* synthetic */ Path copyToRecursively$default(Path path, Path path2, Function3 function3, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            function3 = new Function3() { // from class: kotlin.io.path.PathsKt__PathRecursiveFunctionsKt$copyToRecursively$1
                @Override // kotlin.jvm.functions.Function3
                public final Void invoke(Path path3, Path path4, Exception exception) {
                    Intrinsics.checkNotNullParameter(path3, "<anonymous parameter 0>");
                    Intrinsics.checkNotNullParameter(path4, "<anonymous parameter 1>");
                    Intrinsics.checkNotNullParameter(exception, "exception");
                    throw exception;
                }
            };
        }
        return PathsKt.copyToRecursively(path, path2, (Function3<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult>) function3, z, z2);
    }

    public static final Path copyToRecursively(Path $this$copyToRecursively, Path target, Function3<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult> onError, final boolean followLinks, boolean overwrite) {
        Intrinsics.checkNotNullParameter($this$copyToRecursively, "<this>");
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(onError, "onError");
        if (overwrite) {
            return PathsKt.copyToRecursively($this$copyToRecursively, target, onError, followLinks, new Function3<CopyActionContext, Path, Path, CopyActionResult>() { // from class: kotlin.io.path.PathsKt__PathRecursiveFunctionsKt$copyToRecursively$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public final CopyActionResult invoke(CopyActionContext copyToRecursively, Path src, Path dst) {
                    Intrinsics.checkNotNullParameter(copyToRecursively, "$this$copyToRecursively");
                    Intrinsics.checkNotNullParameter(src, "src");
                    Intrinsics.checkNotNullParameter(dst, "dst");
                    LinkOption[] options = LinkFollowing.INSTANCE.toLinkOptions(followLinks);
                    boolean dstIsDirectory = Files.isDirectory(dst, (LinkOption[]) Arrays.copyOf(new LinkOption[]{LinkOption.NOFOLLOW_LINKS}, 1));
                    LinkOption[] linkOptionArr = (LinkOption[]) Arrays.copyOf(options, options.length);
                    boolean srcIsDirectory = Files.isDirectory(src, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
                    if (!srcIsDirectory || !dstIsDirectory) {
                        if (dstIsDirectory) {
                            PathsKt.deleteRecursively(dst);
                        }
                        SpreadBuilder spreadBuilder = new SpreadBuilder(2);
                        spreadBuilder.addSpread(options);
                        spreadBuilder.add(StandardCopyOption.REPLACE_EXISTING);
                        CopyOption[] copyOptionArr = (CopyOption[]) spreadBuilder.toArray(new CopyOption[spreadBuilder.size()]);
                        Intrinsics.checkNotNullExpressionValue(Files.copy(src, dst, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length)), "copy(this, target, *options)");
                    }
                    return CopyActionResult.CONTINUE;
                }
            });
        }
        return PathsKt.copyToRecursively$default($this$copyToRecursively, target, onError, followLinks, (Function3) null, 8, (Object) null);
    }

    public static /* synthetic */ Path copyToRecursively$default(Path path, Path path2, Function3 function3, final boolean z, Function3 function32, int i, Object obj) {
        if ((i & 2) != 0) {
            function3 = new Function3() { // from class: kotlin.io.path.PathsKt__PathRecursiveFunctionsKt$copyToRecursively$3
                @Override // kotlin.jvm.functions.Function3
                public final Void invoke(Path path3, Path path4, Exception exception) {
                    Intrinsics.checkNotNullParameter(path3, "<anonymous parameter 0>");
                    Intrinsics.checkNotNullParameter(path4, "<anonymous parameter 1>");
                    Intrinsics.checkNotNullParameter(exception, "exception");
                    throw exception;
                }
            };
        }
        if ((i & 8) != 0) {
            function32 = new Function3<CopyActionContext, Path, Path, CopyActionResult>() { // from class: kotlin.io.path.PathsKt__PathRecursiveFunctionsKt$copyToRecursively$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public final CopyActionResult invoke(CopyActionContext $this$null, Path src, Path dst) {
                    Intrinsics.checkNotNullParameter($this$null, "$this$null");
                    Intrinsics.checkNotNullParameter(src, "src");
                    Intrinsics.checkNotNullParameter(dst, "dst");
                    return $this$null.copyToIgnoringExistingDirectory(src, dst, z);
                }
            };
        }
        return PathsKt.copyToRecursively(path, path2, (Function3<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult>) function3, z, (Function3<? super CopyActionContext, ? super Path, ? super Path, ? extends CopyActionResult>) function32);
    }

    public static final Path copyToRecursively(final Path $this$copyToRecursively, final Path target, final Function3<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult> onError, boolean followLinks, final Function3<? super CopyActionContext, ? super Path, ? super Path, ? extends CopyActionResult> copyAction) {
        Intrinsics.checkNotNullParameter($this$copyToRecursively, "<this>");
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Intrinsics.checkNotNullParameter(copyAction, "copyAction");
        LinkOption[] linkOptions = LinkFollowing.INSTANCE.toLinkOptions(followLinks);
        LinkOption[] linkOptionArr = (LinkOption[]) Arrays.copyOf(linkOptions, linkOptions.length);
        if (!Files.exists($this$copyToRecursively, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length))) {
            throw new NoSuchFileException($this$copyToRecursively.toString(), target.toString(), "The source file doesn't exist.");
        }
        boolean isSubdirectory = false;
        if (Files.exists($this$copyToRecursively, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0)) && (followLinks || !Files.isSymbolicLink($this$copyToRecursively))) {
            boolean targetExistsAndNotSymlink = Files.exists(target, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0)) && !Files.isSymbolicLink(target);
            if (!targetExistsAndNotSymlink || !Files.isSameFile($this$copyToRecursively, target)) {
                if (Intrinsics.areEqual($this$copyToRecursively.getFileSystem(), target.getFileSystem())) {
                    if (targetExistsAndNotSymlink) {
                        isSubdirectory = target.toRealPath(new LinkOption[0]).startsWith($this$copyToRecursively.toRealPath(new LinkOption[0]));
                    } else {
                        Path it = target.getParent();
                        if (it != null && Files.exists(it, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0)) && it.toRealPath(new LinkOption[0]).startsWith($this$copyToRecursively.toRealPath(new LinkOption[0]))) {
                            isSubdirectory = true;
                        }
                    }
                }
                if (isSubdirectory) {
                    throw new FileSystemException($this$copyToRecursively.toString(), target.toString(), "Recursively copying a directory into its subdirectory is prohibited.");
                }
            }
        }
        PathsKt.visitFileTree$default($this$copyToRecursively, 0, followLinks, new Function1<FileVisitorBuilder, Unit>() { // from class: kotlin.io.path.PathsKt__PathRecursiveFunctionsKt$copyToRecursively$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            /* compiled from: PathRecursiveFunctions.kt */
            @Metadata(k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            /* renamed from: kotlin.io.path.PathsKt__PathRecursiveFunctionsKt$copyToRecursively$5$1, reason: invalid class name */
            /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function2<Path, BasicFileAttributes, FileVisitResult> {
                final /* synthetic */ Function3<CopyActionContext, Path, Path, CopyActionResult> $copyAction;
                final /* synthetic */ Function3<Path, Path, Exception, OnErrorResult> $onError;
                final /* synthetic */ Path $target;
                final /* synthetic */ Path $this_copyToRecursively;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                AnonymousClass1(Function3<? super CopyActionContext, ? super Path, ? super Path, ? extends CopyActionResult> function3, Path path, Path path2, Function3<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult> function32) {
                    super(2, Intrinsics.Kotlin.class, "copy", "copyToRecursively$copy$PathsKt__PathRecursiveFunctionsKt(Lkotlin/jvm/functions/Function3;Ljava/nio/file/Path;Ljava/nio/file/Path;Lkotlin/jvm/functions/Function3;Ljava/nio/file/Path;Ljava/nio/file/attribute/BasicFileAttributes;)Ljava/nio/file/FileVisitResult;", 0);
                    this.$copyAction = function3;
                    this.$this_copyToRecursively = path;
                    this.$target = path2;
                    this.$onError = function32;
                }

                @Override // kotlin.jvm.functions.Function2
                public final FileVisitResult invoke(Path p0, BasicFileAttributes p1) {
                    FileVisitResult copyToRecursively$copy$PathsKt__PathRecursiveFunctionsKt;
                    Intrinsics.checkNotNullParameter(p0, "p0");
                    Intrinsics.checkNotNullParameter(p1, "p1");
                    copyToRecursively$copy$PathsKt__PathRecursiveFunctionsKt = PathsKt__PathRecursiveFunctionsKt.copyToRecursively$copy$PathsKt__PathRecursiveFunctionsKt(this.$copyAction, this.$this_copyToRecursively, this.$target, this.$onError, p0, p1);
                    return copyToRecursively$copy$PathsKt__PathRecursiveFunctionsKt;
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FileVisitorBuilder fileVisitorBuilder) {
                invoke2(fileVisitorBuilder);
                return Unit.INSTANCE;
            }

            /* compiled from: PathRecursiveFunctions.kt */
            @Metadata(k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            /* renamed from: kotlin.io.path.PathsKt__PathRecursiveFunctionsKt$copyToRecursively$5$2, reason: invalid class name */
            /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function2<Path, BasicFileAttributes, FileVisitResult> {
                final /* synthetic */ Function3<CopyActionContext, Path, Path, CopyActionResult> $copyAction;
                final /* synthetic */ Function3<Path, Path, Exception, OnErrorResult> $onError;
                final /* synthetic */ Path $target;
                final /* synthetic */ Path $this_copyToRecursively;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                AnonymousClass2(Function3<? super CopyActionContext, ? super Path, ? super Path, ? extends CopyActionResult> function3, Path path, Path path2, Function3<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult> function32) {
                    super(2, Intrinsics.Kotlin.class, "copy", "copyToRecursively$copy$PathsKt__PathRecursiveFunctionsKt(Lkotlin/jvm/functions/Function3;Ljava/nio/file/Path;Ljava/nio/file/Path;Lkotlin/jvm/functions/Function3;Ljava/nio/file/Path;Ljava/nio/file/attribute/BasicFileAttributes;)Ljava/nio/file/FileVisitResult;", 0);
                    this.$copyAction = function3;
                    this.$this_copyToRecursively = path;
                    this.$target = path2;
                    this.$onError = function32;
                }

                @Override // kotlin.jvm.functions.Function2
                public final FileVisitResult invoke(Path p0, BasicFileAttributes p1) {
                    FileVisitResult copyToRecursively$copy$PathsKt__PathRecursiveFunctionsKt;
                    Intrinsics.checkNotNullParameter(p0, "p0");
                    Intrinsics.checkNotNullParameter(p1, "p1");
                    copyToRecursively$copy$PathsKt__PathRecursiveFunctionsKt = PathsKt__PathRecursiveFunctionsKt.copyToRecursively$copy$PathsKt__PathRecursiveFunctionsKt(this.$copyAction, this.$this_copyToRecursively, this.$target, this.$onError, p0, p1);
                    return copyToRecursively$copy$PathsKt__PathRecursiveFunctionsKt;
                }
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(FileVisitorBuilder visitFileTree) {
                Intrinsics.checkNotNullParameter(visitFileTree, "$this$visitFileTree");
                visitFileTree.onPreVisitDirectory(new AnonymousClass1(copyAction, $this$copyToRecursively, target, onError));
                visitFileTree.onVisitFile(new AnonymousClass2(copyAction, $this$copyToRecursively, target, onError));
                visitFileTree.onVisitFileFailed(new AnonymousClass3(onError, $this$copyToRecursively, target));
                final Function3<Path, Path, Exception, OnErrorResult> function3 = onError;
                final Path path = $this$copyToRecursively;
                final Path path2 = target;
                visitFileTree.onPostVisitDirectory(new Function2<Path, IOException, FileVisitResult>() { // from class: kotlin.io.path.PathsKt__PathRecursiveFunctionsKt$copyToRecursively$5.4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final FileVisitResult invoke(Path directory, IOException exception) {
                        FileVisitResult copyToRecursively$error$PathsKt__PathRecursiveFunctionsKt;
                        Intrinsics.checkNotNullParameter(directory, "directory");
                        if (exception != null) {
                            copyToRecursively$error$PathsKt__PathRecursiveFunctionsKt = PathsKt__PathRecursiveFunctionsKt.copyToRecursively$error$PathsKt__PathRecursiveFunctionsKt(function3, path, path2, directory, exception);
                            return copyToRecursively$error$PathsKt__PathRecursiveFunctionsKt;
                        }
                        return FileVisitResult.CONTINUE;
                    }
                });
            }

            /* compiled from: PathRecursiveFunctions.kt */
            @Metadata(k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            /* renamed from: kotlin.io.path.PathsKt__PathRecursiveFunctionsKt$copyToRecursively$5$3, reason: invalid class name */
            /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function2<Path, Exception, FileVisitResult> {
                final /* synthetic */ Function3<Path, Path, Exception, OnErrorResult> $onError;
                final /* synthetic */ Path $target;
                final /* synthetic */ Path $this_copyToRecursively;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                AnonymousClass3(Function3<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult> function3, Path path, Path path2) {
                    super(2, Intrinsics.Kotlin.class, "error", "copyToRecursively$error$PathsKt__PathRecursiveFunctionsKt(Lkotlin/jvm/functions/Function3;Ljava/nio/file/Path;Ljava/nio/file/Path;Ljava/nio/file/Path;Ljava/lang/Exception;)Ljava/nio/file/FileVisitResult;", 0);
                    this.$onError = function3;
                    this.$this_copyToRecursively = path;
                    this.$target = path2;
                }

                @Override // kotlin.jvm.functions.Function2
                public final FileVisitResult invoke(Path p0, Exception p1) {
                    FileVisitResult copyToRecursively$error$PathsKt__PathRecursiveFunctionsKt;
                    Intrinsics.checkNotNullParameter(p0, "p0");
                    Intrinsics.checkNotNullParameter(p1, "p1");
                    copyToRecursively$error$PathsKt__PathRecursiveFunctionsKt = PathsKt__PathRecursiveFunctionsKt.copyToRecursively$error$PathsKt__PathRecursiveFunctionsKt(this.$onError, this.$this_copyToRecursively, this.$target, p0, p1);
                    return copyToRecursively$error$PathsKt__PathRecursiveFunctionsKt;
                }
            }
        }, 1, (Object) null);
        return target;
    }

    private static final Path copyToRecursively$destination$PathsKt__PathRecursiveFunctionsKt(Path $this_copyToRecursively, Path $target, Path source) {
        Path relativePath = PathsKt.relativeTo(source, $this_copyToRecursively);
        Path resolve = $target.resolve(relativePath.toString());
        Intrinsics.checkNotNullExpressionValue(resolve, "target.resolve(relativePath.pathString)");
        return resolve;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FileVisitResult copyToRecursively$error$PathsKt__PathRecursiveFunctionsKt(Function3<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult> function3, Path $this_copyToRecursively, Path $target, Path source, Exception exception) {
        return toFileVisitResult$PathsKt__PathRecursiveFunctionsKt(function3.invoke(source, copyToRecursively$destination$PathsKt__PathRecursiveFunctionsKt($this_copyToRecursively, $target, source), exception));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FileVisitResult copyToRecursively$copy$PathsKt__PathRecursiveFunctionsKt(Function3<? super CopyActionContext, ? super Path, ? super Path, ? extends CopyActionResult> function3, Path $this_copyToRecursively, Path $target, Function3<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult> function32, Path source, BasicFileAttributes attributes) {
        try {
            return toFileVisitResult$PathsKt__PathRecursiveFunctionsKt(function3.invoke(DefaultCopyActionContext.INSTANCE, source, copyToRecursively$destination$PathsKt__PathRecursiveFunctionsKt($this_copyToRecursively, $target, source)));
        } catch (Exception exception) {
            return copyToRecursively$error$PathsKt__PathRecursiveFunctionsKt(function32, $this_copyToRecursively, $target, source, exception);
        }
    }

    private static final FileVisitResult toFileVisitResult$PathsKt__PathRecursiveFunctionsKt(CopyActionResult $this$toFileVisitResult) {
        switch (WhenMappings.$EnumSwitchMapping$0[$this$toFileVisitResult.ordinal()]) {
            case 1:
                return FileVisitResult.CONTINUE;
            case 2:
                return FileVisitResult.TERMINATE;
            case 3:
                return FileVisitResult.SKIP_SUBTREE;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private static final FileVisitResult toFileVisitResult$PathsKt__PathRecursiveFunctionsKt(OnErrorResult $this$toFileVisitResult) {
        switch (WhenMappings.$EnumSwitchMapping$1[$this$toFileVisitResult.ordinal()]) {
            case 1:
                return FileVisitResult.TERMINATE;
            case 2:
                return FileVisitResult.SKIP_SUBTREE;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final void deleteRecursively(Path $this$deleteRecursively) {
        Intrinsics.checkNotNullParameter($this$deleteRecursively, "<this>");
        Iterable suppressedExceptions = deleteRecursivelyImpl$PathsKt__PathRecursiveFunctionsKt($this$deleteRecursively);
        if (!((Collection) suppressedExceptions).isEmpty()) {
            FileSystemException $this$deleteRecursively_u24lambda_u242 = new FileSystemException("Failed to delete one or more files. See suppressed exceptions for details.");
            Iterable $this$forEach$iv = suppressedExceptions;
            for (Object element$iv : $this$forEach$iv) {
                Exception it = (Exception) element$iv;
                ExceptionsKt.addSuppressed($this$deleteRecursively_u24lambda_u242, it);
            }
            throw $this$deleteRecursively_u24lambda_u242;
        }
    }

    private static final List<Exception> deleteRecursivelyImpl$PathsKt__PathRecursiveFunctionsKt(Path $this$deleteRecursivelyImpl) {
        DirectoryStream directoryStream;
        ExceptionsCollector collector = new ExceptionsCollector(0, 1, null);
        boolean useInsecure = true;
        Path parent = $this$deleteRecursivelyImpl.getParent();
        if (parent != null) {
            try {
                directoryStream = Files.newDirectoryStream(parent);
            } catch (Throwable th) {
                directoryStream = null;
            }
            if (directoryStream != null) {
                DirectoryStream directoryStream2 = directoryStream;
                try {
                    DirectoryStream stream = directoryStream2;
                    if (stream instanceof SecureDirectoryStream) {
                        useInsecure = false;
                        collector.setPath(parent);
                        Path fileName = $this$deleteRecursivelyImpl.getFileName();
                        Intrinsics.checkNotNullExpressionValue(fileName, "this.fileName");
                        handleEntry$PathsKt__PathRecursiveFunctionsKt((SecureDirectoryStream) stream, fileName, collector);
                    }
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(directoryStream2, null);
                } finally {
                }
            }
        }
        if (useInsecure) {
            insecureHandleEntry$PathsKt__PathRecursiveFunctionsKt($this$deleteRecursivelyImpl, collector);
        }
        return collector.getCollectedExceptions();
    }

    private static final void collectIfThrows$PathsKt__PathRecursiveFunctionsKt(ExceptionsCollector collector, Function0<Unit> function0) {
        try {
            function0.invoke();
        } catch (Exception exception) {
            collector.collect(exception);
        }
    }

    private static final <R> R tryIgnoreNoSuchFileException$PathsKt__PathRecursiveFunctionsKt(Function0<? extends R> function0) {
        try {
            return function0.invoke();
        } catch (NoSuchFileException e) {
            return null;
        }
    }

    private static final void handleEntry$PathsKt__PathRecursiveFunctionsKt(SecureDirectoryStream<Path> secureDirectoryStream, Path name, ExceptionsCollector collector) {
        collector.enterEntry(name);
        try {
            if (isDirectory$PathsKt__PathRecursiveFunctionsKt(secureDirectoryStream, name, LinkOption.NOFOLLOW_LINKS)) {
                int preEnterTotalExceptions = collector.getTotalExceptions();
                enterDirectory$PathsKt__PathRecursiveFunctionsKt(secureDirectoryStream, name, collector);
                if (preEnterTotalExceptions == collector.getTotalExceptions()) {
                    try {
                        secureDirectoryStream.deleteDirectory(name);
                        Unit unit = Unit.INSTANCE;
                    } catch (NoSuchFileException e) {
                    }
                }
            } else {
                try {
                    secureDirectoryStream.deleteFile(name);
                    Unit unit2 = Unit.INSTANCE;
                } catch (NoSuchFileException e2) {
                }
            }
        } catch (Exception exception$iv) {
            collector.collect(exception$iv);
        }
        collector.exitEntry(name);
    }

    private static final void enterDirectory$PathsKt__PathRecursiveFunctionsKt(SecureDirectoryStream<Path> secureDirectoryStream, Path name, ExceptionsCollector collector) {
        SecureDirectoryStream secureDirectoryStream2;
        try {
            try {
                secureDirectoryStream2 = secureDirectoryStream.newDirectoryStream(name, LinkOption.NOFOLLOW_LINKS);
            } catch (Exception exception$iv) {
                collector.collect(exception$iv);
                return;
            }
        } catch (NoSuchFileException e) {
            secureDirectoryStream2 = null;
        }
        if (secureDirectoryStream2 == null) {
            return;
        }
        SecureDirectoryStream secureDirectoryStream3 = secureDirectoryStream2;
        try {
            SecureDirectoryStream directoryStream = secureDirectoryStream3;
            for (Path entry : directoryStream) {
                Path fileName = entry.getFileName();
                Intrinsics.checkNotNullExpressionValue(fileName, "entry.fileName");
                handleEntry$PathsKt__PathRecursiveFunctionsKt(directoryStream, fileName, collector);
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(secureDirectoryStream3, null);
        } finally {
        }
    }

    private static final boolean isDirectory$PathsKt__PathRecursiveFunctionsKt(SecureDirectoryStream<Path> secureDirectoryStream, Path entryName, LinkOption... options) {
        Boolean bool;
        try {
            bool = Boolean.valueOf(((BasicFileAttributeView) secureDirectoryStream.getFileAttributeView(entryName, BasicFileAttributeView.class, (LinkOption[]) Arrays.copyOf(options, options.length))).readAttributes().isDirectory());
        } catch (NoSuchFileException e) {
            bool = null;
        }
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    private static final void insecureHandleEntry$PathsKt__PathRecursiveFunctionsKt(Path entry, ExceptionsCollector collector) {
        try {
            if (Files.isDirectory(entry, (LinkOption[]) Arrays.copyOf(new LinkOption[]{LinkOption.NOFOLLOW_LINKS}, 1))) {
                int preEnterTotalExceptions = collector.getTotalExceptions();
                insecureEnterDirectory$PathsKt__PathRecursiveFunctionsKt(entry, collector);
                if (preEnterTotalExceptions == collector.getTotalExceptions()) {
                    Files.deleteIfExists(entry);
                }
            } else {
                Files.deleteIfExists(entry);
            }
        } catch (Exception exception$iv) {
            collector.collect(exception$iv);
        }
    }

    private static final void insecureEnterDirectory$PathsKt__PathRecursiveFunctionsKt(Path path, ExceptionsCollector collector) {
        DirectoryStream directoryStream;
        try {
            try {
                directoryStream = Files.newDirectoryStream(path);
            } catch (Exception exception$iv) {
                collector.collect(exception$iv);
                return;
            }
        } catch (NoSuchFileException e) {
            directoryStream = null;
        }
        if (directoryStream == null) {
            return;
        }
        DirectoryStream directoryStream2 = directoryStream;
        try {
            DirectoryStream directoryStream3 = directoryStream2;
            for (Path entry : directoryStream3) {
                Intrinsics.checkNotNullExpressionValue(entry, "entry");
                insecureHandleEntry$PathsKt__PathRecursiveFunctionsKt(entry, collector);
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(directoryStream2, null);
        } finally {
        }
    }
}
