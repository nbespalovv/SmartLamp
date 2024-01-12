import com.example.smartlamp.domain.GetCurrentColorUseCase
import com.example.smartlamp.repository.SampleRepository
import javax.inject.Inject

class GetCurrentColorUseCaseImpl @Inject constructor(
    private val repository: SampleRepository
) : GetCurrentColorUseCase {
    override suspend fun invoke(): Result<String?> =
        repository.getCurrentColor()
}
