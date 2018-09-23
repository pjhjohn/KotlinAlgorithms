package study.kotlin.chapter1.filepermission

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.After
import org.junit.Before
import org.junit.Test
import study.kotlin.chapter1.UnitTestWatcher

class FilePermissionUnitTest : UnitTestWatcher() {

    @Before
    fun before() {

    }

    @After
    fun after() {

    }

    @Test
    fun testFilePermission() {

        assertThat(FilePermission.symbolicToOctal("rwxrwxrwx")).isEqualTo(777)
        assertThat(FilePermission.symbolicToOctal("rwxrwx---")).isEqualTo(770)
        assertThat(FilePermission.symbolicToOctal("rw-rw-rw-")).isEqualTo(666)
        assertThat(FilePermission.symbolicToOctal("rw-----wx")).isEqualTo(603)
        assertThat(FilePermission.symbolicToOctal("-wxr-xrw-")).isEqualTo(356)
        assertThat(FilePermission.symbolicToOctal("rwxr-xr-x")).isEqualTo(755)
        assertThat(FilePermission.symbolicToOctal("rw-r--r--")).isEqualTo(644)
        assertThat(FilePermission.symbolicToOctal("---------")).isEqualTo(0)

        assertThatIllegalArgumentException().isThrownBy { FilePermission.symbolicToOctal("") }
        assertThatIllegalArgumentException().isThrownBy { FilePermission.symbolicToOctal("rwxrwxrw ") }
        assertThatIllegalArgumentException().isThrownBy { FilePermission.symbolicToOctal("rwxrwxrwa") }
        assertThatIllegalArgumentException().isThrownBy { FilePermission.symbolicToOctal("rwxrwxrwxrwx") }
    }

}
